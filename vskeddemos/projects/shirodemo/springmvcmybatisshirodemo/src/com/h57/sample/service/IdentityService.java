/*
 * This file is licensed to you under the BSD License, (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 * 
 * http://www.opensource.org/licenses/bsd-license.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.h57.sample.service;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.h57.sample.domain.Identity;
import com.h57.sample.form.RegistrationForm;
import com.h57.sample.persistence.IdentityMapper;

/**
 * myBatis Identity Service for our Identity Domain object
 * 
 * @author Bubba Hines (bubba@hines57.com)
 * @since 0.02
 */
@Service
@PropertySource("classpath:application.properties")
public class IdentityService {

  @Autowired
  private Environment env;

  public void setEnv(Environment env) {
    this.env = env;
  }

  @Autowired(required = true)
  private IdentityMapper identityMapper;

  private static final Logger logger = LoggerFactory.getLogger(IdentityService.class);

  public IdentityMapper getIdentityMapper() {
    return identityMapper;
  }

  public Identity registerIdentity(RegistrationForm registration) {

    registration.setSalt(getSalt());
    registration.setPassphrase(encodePassphrase(registration.getPassphrase(), registration.getSalt()));

    // Insert the Identity
    identityMapper.registerIdentity(registration);

    logger.trace("INSERTED ID = (" + registration.getId() + ")");
    // Get a new Identity object, fully populated from the DB
    return this.getIdentity(registration.getId());

  }

  public static String getSalt() {
    return new SecureRandomNumberGenerator().nextBytes().toBase64();
  }

  public String getApplicationSalt() {
    return env.getProperty("shiro.applicationSalt");
  }

  public String getCombinedSalt(String salt) {
    return env.getProperty("shiro.applicationSalt") + ":" + salt;
  }

  public String encodePassphrase(String rawPassphrase, String salt) {
    return new Sha512Hash(rawPassphrase, getCombinedSalt(salt), getIterations()).toBase64();
  }

  public Integer getIterations() {
    return Integer.parseInt(env.getProperty("shiro.hashIterations"));
  }

  public Identity getIdentity(int id) {
    logger.trace("Entering getIdentity(" + id + ")");
    if (identityMapper == null) {
      logger.debug("identityMapper didn't get autowired!");
    }
    return identityMapper.getIdentityById(id);
  }

  public Identity getIdentity(String userId) {
    logger.trace("Entering getIdentity(" + userId + ")");
    if (identityMapper == null) {
      logger.debug("identityMapper didn't get autowired!");
    }
    return identityMapper.getIdentityByUserId(userId);
  }

  public void setIdentityMapper(IdentityMapper identityMapper) {
    this.identityMapper = identityMapper;
  }
}
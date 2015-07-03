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
package com.h57.sample.persistence;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.h57.sample.domain.Identity;
import com.h57.sample.form.RegistrationForm;

/**
 * MyBatis Mapper Interface for our Identity Domain
 * 
 * @author Bubba Hines <bubba@hines57.com>
 * @since 0.02
 */
@Component
public interface IdentityMapper {

  public Identity getIdentityById(@Param("id") int id);

  public Identity getIdentityByUserId(@Param("userId") String userId);

  public Integer registerIdentity(RegistrationForm registration);
}
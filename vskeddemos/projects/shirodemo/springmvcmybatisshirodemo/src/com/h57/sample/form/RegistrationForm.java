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
package com.h57.sample.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * Basic Registration Form with JSR-303 Validation
 * 
 * @author Bubba Hines <bubba@hines57.com>
 * @since 0.02
 */
public class RegistrationForm {

  // TODO: Determine uniqueness of usernames. Don't allow one that is already
  // in the DB?
  @NotNull(message = "User Name field is mandatory.")
  @Size(min = 4, max = 50, message = "User Name field must be greater than 4 but less than 50 characters.")
  private String username;

  // TODO: Determine uniqueness of Email Addresses. Don't allow one that is
  // already in the DB
  @NotNull(message = "Email field is mandatory.")
  @Email(message = "Must be a valid, well formed, email address.")
  private String email;

  @NotNull(message = "Passphrase field is mandatory.")
  @Size(min = 8, max = 50, message = "Passphrase field must be greater than 8 but less than 50 characters.")
  private String passphrase;

  private String salt;

  private Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username.trim();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email.trim();
  }

  public String getPassphrase() {
    return passphrase;
  }

  public void setPassphrase(String passphrase) {
    this.passphrase = passphrase.trim();
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt.trim();
  }

}
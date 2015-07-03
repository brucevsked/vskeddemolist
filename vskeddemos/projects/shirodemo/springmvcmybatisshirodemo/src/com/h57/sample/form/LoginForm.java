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

/**
 * Basic login form with JSR-303 Annotations for validation
 * 
 * @author Bubba Hines <bubba@hines57.com>
 * @since 0.02
 */
public class LoginForm {

  @NotNull(message = "User Name field is mandatory.")
  @Size(min = 4, max = 50, message = "User Name field must be greater than 4 but less than 50 characters.")
  private String username;

  @NotNull(message = "Passphrase field is mandatory.")
  @Size(min = 8, max = 50, message = "Passphrase field must be greater than 8 but less than 50 characters.")
  private String passphrase;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username.trim();
  }

  public String getPassphrase() {
    return passphrase;
  }

  public void setPassphrase(String passphrase) {
    this.passphrase = passphrase.trim();
  }
}
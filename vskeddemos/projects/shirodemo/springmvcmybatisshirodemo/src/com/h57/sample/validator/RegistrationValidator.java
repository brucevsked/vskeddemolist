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
package com.h57.sample.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.h57.sample.form.RegistrationForm;

/**
 * JSR-303 Validator for our Registration Form
 * 
 * @author Bubba Hines <bubba@hines57.com>
 * @since 0.02
 */
public class RegistrationValidator {

  private final Pattern alphaNumPattern;

  RegistrationValidator() {
    this.alphaNumPattern = Pattern.compile("^[a-zA-Z0-9]+$");
  }

  /**
   * This Validator validates just Person instances
   */
  public boolean supports(@SuppressWarnings("rawtypes") Class clazz) {
    return RegistrationForm.class.equals(clazz);
  }

  private boolean isNotAlphaNumeric(String input) {
    Matcher m = this.alphaNumPattern.matcher(input);
    return m.find();
  }

  public void validate(Object obj, Errors e) {
    RegistrationForm r = (RegistrationForm) obj;

    /**
     * Username Validation Can't be Empty Must be Alpha Numeric Must be greater
     * than 3 characters Mush be less than 50 characters TODO: Need to check the
     * DB to verify the userID isn't already in use.
     */
    ValidationUtils.rejectIfEmptyOrWhitespace(e, "username", "username.empty");
    if (this.isNotAlphaNumeric(r.getUsername())) {
      e.rejectValue("username", "username.notAlphaNumberic");
    }
    if (r.getUsername().length() < 3) {
      e.rejectValue("username", "username.toShort");
    }
    if (r.getUsername().length() > 50) {
      e.rejectValue("username", "username.toLong");
    }

    /**
     * Passphrase Validation Can't be Empty Must be greater than 8 characters
     * Mush be less than 50 characters
     */
    ValidationUtils.rejectIfEmptyOrWhitespace(e, "passphrase", "passphrase.empty");
    if (r.getUsername().length() < 8) {
      e.rejectValue("passphrase", "passphrase.toShort");
    }
    if (r.getUsername().length() > 50) {
      e.rejectValue("passphrase", "passphrase.toLong");
    }

    /**
     * Email Validation Can't be Empty TODO: Need to check the DB to verify the
     * email isn't already in use.
     */
    ValidationUtils.rejectIfEmptyOrWhitespace(e, "email", "email.empty");
  }
}

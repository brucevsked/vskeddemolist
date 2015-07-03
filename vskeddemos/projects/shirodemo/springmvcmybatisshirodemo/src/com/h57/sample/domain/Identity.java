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
package com.h57.sample.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * MyBatis Domain object to access Identity information.
 * 
 * @author Bubba Hines <bubba@hines57.com>
 * @since 0.02
 */
public class Identity implements Serializable {
  private static final long serialVersionUID = 1L;

  private int id;
  private String userid;
  private String salt;
  private String email;
  private Date created;

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
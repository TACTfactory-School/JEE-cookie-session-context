package com.tactfactory.tactpoeioctobre2019.entites;

public class User {

  private long id;
  private String firstname;
  private String lastname;
  private Boolean isValidate;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Boolean getIsValidate() {
    return isValidate;
  }

  public void setIsValidate(Boolean isValidate) {
    this.isValidate = isValidate;
  }

  public String toJSON() {
      StringBuilder sb = new StringBuilder();
      sb.append("{");
      sb.append("\"id\":\"" + this.id + "\",");
      sb.append("\"fn\":\"" + this.firstname + "\",");
      sb.append("\"ln\":\"" + this.lastname + "\",");
      sb.append("\"valid\":\"" + this.isValidate + "\"");
      sb.append("}");
      return sb.toString();
  }

public String displayName() {
    return String.format("%s %s", this.firstname, this.lastname);
}

}

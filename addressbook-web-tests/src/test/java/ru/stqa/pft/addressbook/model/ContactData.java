package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String middleName;
  private final String lastName;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String home;
  private final String mobile;
  private final String work;
  private final String fax;
  private final String email1;
  private final String email2;
  private final String email3;
  private String group;

  public ContactData(String name, String middleName, String lastName, String nickname, String title, String company, String address, String home, String mobile, String work, String fax, String email1, String email2, String email3, String group) {
    this.name = name;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getGroup() {  return group;  }
}

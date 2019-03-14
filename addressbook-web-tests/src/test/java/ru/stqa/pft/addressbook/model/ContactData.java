package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String name;
  private final String lastName;
  private String phoneNumber;
  private final String address;
  private final String email1;
  private String group;

  public ContactData( String name, String lastName,String address,String email1, String phoneNumber, String group) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.lastName = lastName;
    this.address = address;
    this.email1 = email1;
    this.phoneNumber = phoneNumber;
    this.group = group;
  }

    public ContactData(int Id, String name, String lastName, String address, String email1, String phoneNumber, String group) {
    this.id = Id;
    this.name = name;
    this.lastName = lastName;
    this.address = address;
    this.email1 = email1;
    this.phoneNumber = phoneNumber;
    this.group = group;
  }

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail1() {
    return email1;
  }

  public String getGroup() {
    return group;
  }

  public int getId() {
    return id;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(name, that.name) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastName);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }
}

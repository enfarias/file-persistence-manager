package com.myproject.com.myproject.domain;

import java.util.List;

public record User(String name, int age, Sex sex, List<Contact> contacts) {

}

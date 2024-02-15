package com.nttdatabc.msbootcoin.utils;

import java.util.UUID;

public class Utilitarios {
  public static String generateUuid(){
    return UUID.randomUUID().toString().replace("-","");
  }
}

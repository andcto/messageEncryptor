package br.com.service;

import com.google.common.io.BaseEncoding;

import java.nio.charset.StandardCharsets;

public class CifraVernamService {

    private static String key = "andreyjunior";

    public static String encode(String message){

        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);

        String expandedKey = expandKey(messageBytes.length);

        byte[] keyBytes = expandedKey.getBytes(StandardCharsets.UTF_8);

        byte[] cipher = new byte[messageBytes.length];
        for (int i = 0; i < messageBytes.length; i++) {
            cipher[i] = (byte) (messageBytes[i] ^ keyBytes[i]);
        }

        //Converte o array de bytes em hexa decimal pois perde informações ao converter novamente para string
        return BaseEncoding.base16().encode(cipher);

    }

    public static String decode(String message){

        CharSequence seq = message;

        byte[] messageBytes = BaseEncoding.base16().decode(seq);

        String expandedKey = expandKey(messageBytes.length);

        byte[] keyBytes = expandedKey.getBytes(StandardCharsets.UTF_8);

        byte[] cipher = new byte[messageBytes.length];
        for (int i = 0; i < messageBytes.length; i++) {
            cipher[i] = (byte) (messageBytes[i] ^ keyBytes[i]);
        }

        return new String(cipher, StandardCharsets.UTF_8);

    }

    public static String expandKey(int length){
        StringBuilder sb = new StringBuilder(key);
        while (sb.length() < length) {
            sb.append(key);
        }
        return sb.toString().substring(0, length);
    }

}

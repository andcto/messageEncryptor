package br.com.service;

class CifraVigenereService {

    public static String encode(String key, String plaintext){

        String ciphertext = "";
        int keyIndex = 0;
        for (int i = 0; i < plaintext.length(); i++) {
            char c = plaintext.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                char ck = key.charAt(keyIndex);
                int shift = calculeShift(ck);
                char encryptedChar = (char)(((c - 'A' + shift) % 26) + 'A');
                ciphertext += encryptedChar;
                keyIndex = (keyIndex + 1) % key.length();
            } else if (c >= 'a' && c <= 'z') {
                char ck = key.charAt(keyIndex);
                int shift = calculeShift(ck);
                char encryptedChar = (char)(((c - 'a' + shift) % 26) + 'a');
                ciphertext += encryptedChar;
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                ciphertext += c;
            }
        }
        return ciphertext;
    }

    public static String decode(String key, String ciphertext){

        String plaintext = "";
        int keyIndex = 0;
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                char ck = key.charAt(keyIndex);
                int shift = calculeShift(ck);
                char decryptedChar = (char)((((c - 'A' - shift) + 26) % 26) + 'A');
                plaintext += decryptedChar;
                keyIndex = (keyIndex + 1) % key.length();
            } else if (c >= 'a' && c <= 'z') {
                char ck = key.charAt(keyIndex);
                int shift = calculeShift(ck);
                char decryptedChar = (char)((((c - 'a' - shift) + 26) % 26) + 'a');
                plaintext += decryptedChar;
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                plaintext += c;
            }
        }
        return plaintext;

    }

    private static int calculeShift(char charKey){

        if(charKey >= 'A' && charKey <= 'Z'){
            return charKey - 'A';
        } else {
            return charKey - 'a';
        }

    }

}

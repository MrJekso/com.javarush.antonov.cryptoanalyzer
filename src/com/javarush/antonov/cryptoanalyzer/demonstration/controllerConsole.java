package com.javarush.antonov.cryptoanalyzer.demonstration;

import com.javarush.antonov.cryptoanalyzer.cipher.Caesar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class controllerConsole {

    private  controllerConsole(){}
    private static Scanner scanner = new Scanner(System.in);
    private static Caesar caesar = Caesar.get();

    public static void сommandHandler() {
        boolean flag = true;
        while (flag) {
            System.out.print("[ * ] Введите номер необходимой команды: ");
            if (scanner.hasNextInt()) {
                int command = scanner.nextInt();
                switch (command){
                    case 1:
                        thisEncryptDecrypt(true);
                        System.out.println("[ УСПЕШНО ]");
                        help();
                        break;
                    case 2:
                        thisEncryptDecrypt(false);
                        System.out.println("[ УСПЕШНО ]");
                        help();
                        break;
                    case 3:
                        System.out.println("[ * ] Досвидания");
                        flag = false;
                        break;
                    default:
                        System.out.println("[ ! Внимание ] Указаного вами номера нет в списке");
                        help();
                }
            } else {
                System.out.println("\n[ ! Внимание ] Проверьте корректность ввода");
                help();
                scanner.next();
            }
        }
    }

    public static void thisEncryptDecrypt(boolean isEncrypt){
        try {
            System.out.println("[ ПРИМЕР ] /home/user/input.txt");
            System.out.print("Введите путь до вашего файла: ");
            String pathNameFileInput = scanner.next();
            if(!(new File(pathNameFileInput).isFile())){
                throw new FileNotFoundException();
            }

            System.out.println("[ ПРИМЕР ] /home/user/result.txt");
            System.out.print("Введите путь и названия файла куда хотите сохранить: ");
            String pathNameFileOutput = scanner.next();

            System.out.println("[ ПРИМЕР ] 23");
            System.out.print("Введите ключ: ");
            int key = scanner.nextInt();

            if (isEncrypt) {
                caesar.encrypt(pathNameFileInput, key, pathNameFileOutput);
            } else {
                caesar.decrypt(pathNameFileInput, key, pathNameFileOutput);
            }

        } catch (FileNotFoundException e) {
            System.out.println("[ ВНИМАНИЕ ] Файл который вы указали не получилось найти или получить к нему доступ. Попробуйте ещё раз.");
            thisEncryptDecrypt(isEncrypt);
        }
    }


    public static void help(){
        System.out.println("[ 1 ] Зашифровать файл");
        System.out.println("[ 2 ] Расшифровать файл");
        System.out.println("[ 3 ] Выйти");
    }

    public static void start(){
        System.out.println("[ * ] Добро пожаловать в анализатор алгоритма Цезарь [ * ]");
        help();
        сommandHandler();
    }

}

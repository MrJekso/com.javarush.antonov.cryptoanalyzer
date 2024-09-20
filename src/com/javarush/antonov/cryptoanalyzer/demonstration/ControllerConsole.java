package com.javarush.antonov.cryptoanalyzer.demonstration;

import com.javarush.antonov.cryptoanalyzer.cipher.Caesar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ControllerConsole {

    private  ControllerConsole(){}
    private static ControllerConsole controllerConsole = new ControllerConsole();
    public static ControllerConsole get() {return  controllerConsole;}
    private  Scanner scanner = new Scanner(System.in);
    private  Caesar caesar = Caesar.get();

    public void сommandHandler() {
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
                        brutForce();
                        System.out.println("[ УСПЕШНО ]");
                        help();
                        break;
                    case 4:
                        System.out.println("[ * ] До свидания");
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


    public  void brutForce(){

        String pathNameFileInput = "";
        String pathNameFileOutput = "";

        try {

            System.out.println("[ ПРИМЕР ] /home/user/input.txt");
            System.out.print("Введите путь до вашего файла: ");
            pathNameFileInput = scanner.next();

            System.out.println("[ ПРИМЕР ] /home/user/result");
            System.out.print("Введите путь и название директории куда сохранить результат: ");
            pathNameFileOutput = scanner.next();


            caesar.brutForce(pathNameFileInput, pathNameFileOutput);

        } catch (FileNotFoundException e) {
            System.out.println("[ ВНИМАНИЕ ] Файл который вы указали не получилось найти или получить к нему доступ. Попробуйте ещё раз.");
            brutForce();
        }
    }

    public  void thisEncryptDecrypt(boolean isEncrypt){

        String pathNameFileInput = "";
        String pathNameFileOutput = "";

        try {

            System.out.println("[ ПРИМЕР ] /home/user/input.txt");
            System.out.print("Введите путь до вашего файла: ");
            pathNameFileInput = scanner.next();

            System.out.println("[ ПРИМЕР ] /home/user/result.txt");
            System.out.print("Введите путь и названия файла куда хотите сохранить: ");
            pathNameFileOutput = scanner.next();

            int key;

            while (true) {
                System.out.println("[ ПРИМЕР ] 23");
                System.out.print("Введите ключ: ");
                if(scanner.hasNextInt()) {
                    key = scanner.nextInt();
                    break;
                }else {
                    System.out.println("\n[ ! Внимание ] Проверьте корректность ввода");
                    scanner.next();
                }
            }

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
        System.out.println("[ 3 ] Расшифровать перебором");
        System.out.println("[ 4 ] Выйти");
    }

    public void start(){
        System.out.println("[ * ] Добро пожаловать в анализатор алгоритма Цезарь [ * ]");
        help();
        сommandHandler();
    }
}
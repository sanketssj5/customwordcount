package com.opensource;

import com.beust.jcommander.JCommander;

class AppStarter {
    public static void main(String args[]) {
        Arguments arguments = new Arguments();
        JCommander.newBuilder()
                .addObject(arguments)
                .build()
                .parse(args);

        System.out.println(arguments.countLines);
//        Scanner scanner = new Scanner(System.in);
//
//        int charCount = 0;
//        while(scanner.hasNextLine()) {
//            String currentLine = scanner.nextLine();
//            charCount += currentLine.length();
//        }
    }
}
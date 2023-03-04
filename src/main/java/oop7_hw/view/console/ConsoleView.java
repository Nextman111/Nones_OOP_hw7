package oop7_hw.view.console;

import oop7_hw.model.data.Note;
import oop7_hw.presenter.Presenter;
import oop7_hw.view.Viewer;

import java.io.IOException;
import java.util.Scanner;

/**
 * класс взаимодействует с пользователем через консоль
 **/
public class ConsoleView extends Viewer<Note> {
    public ConsoleView(Presenter<Note> presenter) {
        super(presenter);
    }

    @Override
    public void view() {
        Commands com;

        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());

                switch (com) {
                    case EXIT -> {
                        return;
                    }
                    case ADD, CREATE -> add();
                    case HELP -> help();
                    case READALL, LIST -> readAll();
                    case READID, READ -> readOfId();
                    case DELETE, REMOVE -> delete();
                    case EDIT, UPDATE -> edit();
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Неизвестная команда.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void help() {
        for (var item : Commands.values()){
            System.out.println(item);
        }
    }

    private void edit() throws Exception {
        if(presenter.edit(getId(), newNote())){
            System.out.println("Запись изменена");
        } else {
            System.out.println("Запись не найдена");
        }
    }

    private void delete() throws Exception {
        if (presenter.delete(getId())){
            System.out.println("Запись удалена");
        } else {
            System.out.println("Запись не найдена");
        }

    }

    private void readOfId() throws Exception {
        try {
            Note note = presenter.readOfId(getId());
            System.out.println(note);
        } catch (Exception e) {
            throw new Exception("id не найден ");
        }

    }

    private void readAll() {
        for (Note item : presenter.readAll()){
            System.out.println(item);
            System.out.println();
        }
    }

    private void add() throws IOException {
        presenter.add(newNote());
        System.out.println("Запись добавлена.");
    }

    private Note newNote() {
        String header = prompt("Заголовок: ");
        String text = prompt("Текст: ");
        return new Note(header,text);
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private int getId() throws Exception {
        String input = prompt("Введите id: ");
        try {
            return Integer.parseInt(input);
        } catch (Exception E) {
            throw new Exception("Неверный формат id.");
        }
    }
}

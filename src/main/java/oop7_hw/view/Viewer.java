package oop7_hw.view;

import oop7_hw.presenter.Presenter;

/** абстрактный класс Viewer с базовыми полями и конструктором,
 * от которого следует наследовать и реализовывать класс отвечающий за "интерфейс" взаимодействия с пользователем **/
public abstract class Viewer<T> implements View {
    public  Presenter<T> presenter;

    public Viewer(Presenter<T> presenter) {
        this.presenter = presenter;
    }
}

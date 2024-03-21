package ru.geekbrains.oop.lesson5;

import ru.geekbrains.oop.lesson5.models.TableService;
import ru.geekbrains.oop.lesson5.presenters.BookingPresenter;
import ru.geekbrains.oop.lesson5.presenters.Model;
import ru.geekbrains.oop.lesson5.views.BookingView;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
        BookingView view = new BookingView();
        Model model = new TableService();
        BookingPresenter presenter = new BookingPresenter(model, view);

        presenter.updateUIShowTables();

        view.reservationTable(new Date(), 2, "Иван Иванов");

        view.changeReservationTable(1001, new Date(), 3, "Иван Иванов");

    }

}

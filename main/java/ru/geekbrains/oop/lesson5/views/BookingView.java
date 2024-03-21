package ru.geekbrains.oop.lesson5.views;

import ru.geekbrains.oop.lesson5.models.Table;
import ru.geekbrains.oop.lesson5.presenters.View;
import ru.geekbrains.oop.lesson5.presenters.ViewObserver;
import ru.geekbrains.oop.lesson5.models.TableService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Представление
 */
public class BookingView implements View {
    public ViewObserver observer;

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    /**
     * @param orderDate
     * @param tableNumber
     * @param nameClients
     */
    @Override
    public void reservationTable(final Date orderDate, final int tableNumber, final String nameClients) {
        if (observer != null) {
            observer.onReservetionTable(orderDate, tableNumber, nameClients);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNumber) {
        if (reservationNumber > 0) {
            System.out.printf("Столик успешно забранирован. Номер вашей брони № %d\n", reservationNumber);
        } else {
            System.out.println("Что-то пошло не так, попробуйте повторить попытку позже.");
        }
    }

    /**
     * @param oldReservation
     * @param reservationDate
     * @param tableNumber
     * @param nameClients
     */
    @Override
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNumber, String nameClients) {
        observer.changeReservationTable(oldReservation, reservationDate, tableNumber, nameClients);
    }

    @Override
    public void showСhangeReservationTable(int newReservationNumber, int newNumberTable) {
        if (newReservationNumber > 0) {
            System.out.printf(
                    "Изменение брони прошло успешно. По номеру брони №%d изменен номер столика. Новый номер столика №%d\n",
                    newReservationNumber, newNumberTable);
        } else {
            System.out.println("Что-то пошло не так, попробуйте повторить попытку позже.");
        }
    }

    @Override
    public void reservationTable(java.sql.Date orderDate, int tableNumber, String nameClients) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reservationTable'");
    }

    @Override
    public void changeReservationTable(int oldReservation, java.sql.Date reservationDate, int tableNumber,
            String nameClients) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeReservationTable'");
    }
}

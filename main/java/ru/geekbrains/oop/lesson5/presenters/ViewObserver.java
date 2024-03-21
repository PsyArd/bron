package ru.geekbrains.oop.lesson5.presenters;

import java.util.Date;

/**
 * Наблюдатель за представлением
 */
public interface ViewObserver {
    /**
     * Произошло событие, пользователь нажал на кнопку резерва столика
     * 
     * @param orderDate   дата резерва
     * @param tableNumber номер столика
     * @param nameClients имя клиента
     */
    void onReservetionTable(Date orderDate, int tableNumber, String nameClients);

    /**
     * Произошло событие изменения брони столика
     * 
     * @param oldReservation  предыдущий номер брони
     * @param reservationDate новая дата брони
     * @param tableNumber     новый номер столика
     * @param nameClients     имя клиента
     */
    void onUpdateReservetionTable(int oldReservation, Date reservationDate, int tableNumber, String nameClients);

    default void changeReservationTable(int oldReservation, Date reservationDate, int tableNumber, String nameClients) {
        if (this != null) {
            onUpdateReservetionTable(oldReservation, reservationDate, tableNumber, nameClients);
        }
    }
}
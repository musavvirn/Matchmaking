package model;

import enums.QueueStateEnum;
import player.Player;

import java.util.ArrayList;
import java.util.Date;

public class Queue {
    private int queueiId;
    private final long TIME_CREATED;
    private long timeActivated;
    private int size;
    private QueueStateEnum queueState;

    private ArrayList<Player> listOfPlayers;

    public Queue() {
        this.queueiId = this.hashCode();
        Date date = new Date();
        this.TIME_CREATED = date.getTime();
        this.size = 0;
        this.queueState = QueueStateEnum.EMPTY;
        this.listOfPlayers = new ArrayList<>();
    }

    /*
        Sets state of queue; If the new state is ACTIVE, resets FIELD @timeActivated;
     */
    public void setState(QueueStateEnum state) {
        this.queueState = state;
        if (state == QueueStateEnum.ACTIVE) {
            this.timeActivated = new Date().getTime();
        }
    }
    /*
        Sets FIELD @queueState to ACTIVE only if currently INACTIVE; throws Exception if already ACTIVE or EMPTY;

        @return: boolean;
     */
    public boolean activate() {
        boolean result;
        if (this.queueState == QueueStateEnum.INACTIVE) {
            this.queueState = QueueStateEnum.ACTIVE;
            this.timeActivated = new Date().getTime();
            result = true;
            System.out.println("Queue has been ACTIVATED!");
        } else if (this.queueState == QueueStateEnum.ACTIVE) {
            result = true;
            System.out.println("Queue already ACTIVE!");

        } else {
            result = false;
            System.out.println("Queue is EMPTY!");

        }
        return result;
    }

    public boolean deactivate() {
        boolean result;
        if (this.queueState == QueueStateEnum.ACTIVE) {
            this.queueState = QueueStateEnum.INACTIVE;
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    /*
        Calculates time since lobby was active; if lobby is INACTIVE or EMPTY, throws Exception & returns 0;
        @return: long time in seconds;
     */
    public long getActiveTime() throws Exception {
        long timeToSec = 0;
        if (this.queueState == QueueStateEnum.ACTIVE) {
            Date date = new Date();
            long time = date.getTime() - this.timeActivated;
            timeToSec = time / 1000;
        } else {
            throw new Exception("Queue was NOT ACTIVATED!");
        }
        return timeToSec;
    }

    public static void main(String[] args) throws Exception {

    }
}

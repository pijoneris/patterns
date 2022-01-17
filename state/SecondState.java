package com.kaboomb.state;

public class SecondState extends State {

    private int count = 0;
    private Client client;

    public SecondState(Client client) {
        this.client = client;
    }

    @Override
    void operation() {
        count += 1;
        System.out.println("SecondState: " + count);

        if (count >= 2) {
            nextState(client);
        }
    }


    @Override
    void nextState(Client client) {
        client.state = new LastState(client);
    }

    @Override
    void previousState(Client client) {
        client.state = new InitialState(client);
    }
}

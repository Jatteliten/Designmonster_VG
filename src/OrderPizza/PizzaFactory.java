package OrderPizza;

import Pizzas.AlTono;
import Pizzas.Capricciosa;
import Pizzas.CustomPizza;
import Pizzas.Funghi;
import Pizzas.LaBussola;
import Pizzas.Margharita;
import Pizzas.Opera;
import Pizzas.Paesana;
import Pizzas.Pizza;
import Pizzas.SoleMio;
import Pizzas.Vesuvio;

public class PizzaFactory {
    public Pizza createPizza(PizzaNames pizza){
        switch(pizza){
            case MARGHARITA -> {
                return new Margharita();
            }
            case VESUVIO -> {
                return new Vesuvio();
            }
            case FUNGHI -> {
                return new Funghi();
            }
            case AL_TONO -> {
                return new AlTono();
            }
            case CAPRICCIOSA -> {
                return new Capricciosa();
            }
            case LA_BUSSOLA -> {
                return new LaBussola();
            }
            case OPERA -> {
                return new Opera();
            }
            case SOLE_MIO -> {
                return new SoleMio();
            }
            case PAESANA -> {
                return new Paesana();
            }
            default -> {
                return new CustomPizza();
            }
        }
    }
}

package org.mvpigs.pigcoin;

import java.security.KeyPair;

public class App {

    public static void main( String[] args )
    {
        /**
         * Crea una wallet
         * Genera las claves privada y publica de la wallet 
         */

        System.out.println("\n" + "Ver clave Privada y clave Pública de una wallet" + "\n" + 
                                  "==============================================="        );
                       
        Wallet wallet_1 = new Wallet();
        KeyPair pair = GenSig.generateKeyPair();
        wallet_1.setSK(pair.getPrivate());
        wallet_1.setAddress(pair.getPublic());

        System.out.println("\n Direccion de la Wallet_1: \n" + wallet_1.getAddress().getEncoded());

        /**
         * Crea una segunda wallet, esta vez generando sus claves
         * con un metodo wallet.generateKeyPair() que encapsula
         * el codigo de la anterior historia de usuario
         */

        Wallet wallet_2 = new Wallet();
        wallet_2.generateKeyPair();

        System.out.println("\n Direccion de la Wallet_2: \n" + wallet_2.getAddress().getEncoded());

        /**
         * Visualiza las Wallet 1 y 2
         */
        
        System.out.println("\n" + "Ver Wallets 1 y 2" + "\n" + 
                                  "================="        );

        System.out.println("Wallet_1: \n" + wallet_1.toString());
        System.out.println("Wallet_2: \n" + wallet_2.toString());   

        /**
         * Crea una transaccion de pigcoins 
         * que incluiremos mas tarde en el blockchain
         * Visualiza la transaccion
         */

        System.out.println("\n" + "Ver transaccion" + "\n" +
                                  "==============="        );

        Transaction trx = new Transaction();
        trx = new Transaction("hash_1", "0", wallet_1.getAddress(), wallet_2.getAddress(), 20);
        
        System.out.println(trx.toString());

        /**
         * Crea el blockchain
         * y añade transacciones que crean moneda "pigcoins"
         */

        System.out.println("\n" + "Ver BlockChain" + "\n" + 
                                  "=============="        );
        
        // Crea primero la direccion "origen" del sistema que genera los pigcoins

        Wallet origin = new Wallet();
        origin.generateKeyPair();

        BlockChain bChain = new BlockChain();
        trx = new Transaction("hash_1", "0", origin.getAddress(), wallet_1.getAddress(), 20);
        bChain.addOrigin(trx);
        trx = new Transaction("hash_2", "1", origin.getAddress(), wallet_2.getAddress(), 10);
        bChain.addOrigin(trx);
        trx = new Transaction("hash_3", "2", wallet_1.getAddress(), wallet_2.getAddress(), 10);
        bChain.addOrigin(trx);
        
        // Visualiza el blockchain
                
        bChain.summarize();
        
        /**
         * Ve la transaccion de una posicion determinada del blockchain
         */
        
        Integer position = 1;
        System.out.println("\n" + "Ver Transaccion en posicion " + position.toString() + " del BlockChain" + "\n" + 
                                  "============================================"        );
        bChain.summarize(position);        

        /**
         * Indicar en la wallet
         * el total de pigcoins que se han enviado,
         * que se han recibido
         * y el balance
         */

        System.out.println("\n" + "Ver el total de pigcoins de las dos wallet" + "\n" + 
                                  "======================================"        );
        
        wallet_1.loadCoins(bChain);
        System.out.println(wallet_1.toString());

        wallet_2.loadCoins(bChain);
        System.out.println(wallet_2.toString());        

        /**
         * Cargar en la wallet el total de transacciones recibidas
         * (aquellas que significan recibir pigcoins)
         * y enviadas (aquellas que envian pigcoins)
         * y mostrarlas
         */

        /*
        System.out.println("\n" + "Ver las transacciones entrantes de la wallet_1" + "\n" + 
                                  "============================================="        );
        wallet_1.loadInputTransactions(bChain);
        System.out.println("Wallet = " + wallet_1.getAddress());
        System.out.println("Transacciones = " + wallet_1.getInputTransactions().toString());

        System.out.println("\n" + "Ver las transacciones enviadas de una wallet_1" + "\n" + 
                                  "============================================="        );
        wallet_1.loadOutputTransactions(bChain);
        System.out.println("Wallet = " + wallet_1.getAddress());
        System.out.println("Transacciones = " + wallet_1.getOutputTransactions().toString());

        System.out.println("\n" + "Ver las transacciones entrantes de la wallet_2" + "\n" + 
                                  "============================================="        );
        wallet_2.loadInputTransactions(bChain);
        System.out.println("Wallet = " + wallet_1.getAddress());
        System.out.println("Transacciones = " + wallet_2.getInputTransactions().toString());

        */

        /**
         * Enviar pigcoins de la wallet_1 a la wallet_2 
         */

        /*
        System.out.println("\n" + ">>> Wallet_1 envia transaccion de 5.2 pigcoins a wallet_2 >>>" + "\n");

        System.out.println("\n" + "Ver el total de pigcoins de las dos wallet" + "\n" + 
                                  "======================================"            );

        wallet_1.sendCoins(wallet_2.getAddress(), 5.2, bChain);
        wallet_2.loadCoins(bChain);

        System.out.println(wallet_1.toString());
        System.out.println(wallet_2.toString());      
        */  
    }
}

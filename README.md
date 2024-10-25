# Transaction-Server
A transaction server using OCC for our CS465 class


Compile from main folder with this:

```javac -d build -sourcepath src src/transaction/client/*.java src/transaction/comm/*.java src/transaction/server/account/*.java src/transaction/server/transaction/*.java src/transaction/server/*.java src/utils/*.java```

# Run Server

from main folder:

```java -cp build transaction.server.TransactionServer config/TransactionServer.properties```

# Run Client

from main folder:

```java -cp build transaction.client.TransactionClient config/TransactionClient.properties config/TransactionServer.properties```
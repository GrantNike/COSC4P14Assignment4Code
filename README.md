# Instructions for running code 
#Compile and Run in same line
1. Compile and run server file including the optional argument like so: "java Server.java (portNumber)". The default port number with no arguments is 4000.
2. Then compile and run the client file where both arguments are required like so: "java client.java (hostName) (portNumber)"
#Compile first and then Run
1. Compile server with command: "javac Server.java" then compile client with command: "javac client.java"
2. Run server file including the optional argument like so: "java Server (portNumber)". The default port number with no arguments is 4000.
3. Then Run the client file in a separate terminal, where both arguments are required like so: "java client (hostName) (portNumber)".
4. Once the client connects to the server, the client can send strings to the server and recieve strings back over an encrypted channel.
5. CTRL+C will close both the client and server programs. Each will have to be closed individually. 

public class Main
{
    public static void main(String[] args)
    {
        EchoServer server = new EchoServer(4242);
        server.start();
    }
}

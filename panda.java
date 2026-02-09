import java.io.FileWriter;
import java.io.IOException;

public class Panda {
    public static void main(String[] args) {
        String[] images = {
            "https://images.unsplash.com/photo-1506744038136-46273834b3fb",
            "https://images.unsplash.com/photo-1465101046530-73398c7f28ca",
            "https://images.unsplash.com/photo-1500534314209-a25ddb2bd429",
            "https://images.unsplash.com/photo-1465101178521-c1a9136a3b99",
            "https://images.unsplash.com/photo-1465101046530-73398c7f28ca"
        };
        StringBuilder imgArray = new StringBuilder();
        for (int i = 0; i < images.length; i++) {
            imgArray.append('"').append(images[i]).append('"');
            if (i < images.length - 1) imgArray.append(", ");
        }
        String html = """
        <!DOCTYPE html>
        <html>
        <head>
            <title>Beautiful World</title>
            <style>
                body {
                    margin: 0;
                    padding: 0;
                    height: 100vh;
                    width: 100vw;
                    background-size: cover;
                    background-position: center;
                    transition: background-image 1s ease-in-out;
                }
                .title {
                    position: absolute;
                    top: 50%;
                    left: 50%;
                    transform: translate(-50%, -50%);
                    color: #fff;
                    background: rgba(0,0,0,0.4);
                    padding: 30px 60px;
                    border-radius: 20px;
                    font-size: 3em;
                    font-family: Arial, sans-serif;
                    text-shadow: 2px 2px 8px #000;
                }
            </style>
        </head>
        <body>
            <div class=\"title\">Beautiful World</div>
            <script>
                const images = [%s];
                function setRandomBg() {
                    const idx = Math.floor(Math.random() * images.length);
                    document.body.style.backgroundImage = `url('${images[idx]}?auto=format&fit=crop&w=1200&q=80')`;
                }
                setRandomBg();
                setInterval(setRandomBg, 5000);
            </script>
        </body>
        </html>
        """.formatted(imgArray.toString());
        try (FileWriter writer = new FileWriter("beautiful_world.html")) {
            writer.write(html);
            System.out.println("HTML file 'beautiful_world.html' created. Open it in your browser.");
        } catch (IOException e) {
            System.out.println("Error writing HTML file: " + e.getMessage());
        }
    }
}

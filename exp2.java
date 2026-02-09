import java.io.FileWriter;
import java.io.IOException;

public class Exp2 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 9; i++) sum += i;
        String html = """
        <!DOCTYPE html>
        <html>
        <head>
            <title>Addition Animation</title>
            <style>
                body {
                    margin: 0;
                    padding: 0;
                    overflow: hidden;
                    background: #b3e0ff;
                    width: 100vw;
                    height: 100vh;
                }
                #sum {
                    position: absolute;
                    font-size: 3em;
                    color: #003366;
                    font-family: Arial, sans-serif;
                    font-weight: bold;
                    text-shadow: 2px 2px 8px #fff;
                }
                .star {
                    position: absolute;
                    width: 6px;
                    height: 6px;
                    background: #fff;
                    border-radius: 50%;
                    opacity: 0.8;
                    box-shadow: 0 0 8px #fff, 0 0 16px #b3e0ff;
                }
            </style>
        </head>
        <body>
            <div id=\"sum\">1+2+3+4+5+6+7+8+9 = %d</div>
            <script>
                // Animate sum
                const sum = document.getElementById('sum');
                let x = 100, y = 100;
                let dx = 2 + Math.random()*2, dy = 2 + Math.random()*2;
                function moveSum() {
                    const w = window.innerWidth - sum.offsetWidth;
                    const h = window.innerHeight - sum.offsetHeight;
                    x += dx;
                    y += dy;
                    if (x < 0 || x > w) dx = -dx;
                    if (y < 0 || y > h) dy = -dy;
                    x = Math.max(0, Math.min(x, w));
                    y = Math.max(0, Math.min(y, h));
                    sum.style.left = x + 'px';
                    sum.style.top = y + 'px';
                    requestAnimationFrame(moveSum);
                }
                moveSum();
                // Create stars
                const starCount = 80;
                for (let i = 0; i < starCount; i++) {
                    const star = document.createElement('div');
                    star.className = 'star';
                    star.style.left = Math.random()*window.innerWidth + 'px';
                    star.style.top = Math.random()*window.innerHeight + 'px';
                    document.body.appendChild(star);
                    // Animate twinkle
                    setInterval(() => {
                        star.style.opacity = 0.5 + Math.random()*0.5;
                    }, 1000 + Math.random()*2000);
                }
            </script>
        </body>
        </html>
        """.formatted(sum);
        try (FileWriter writer = new FileWriter("addition_animation.html")) {
            writer.write(html);
            System.out.println("HTML file 'addition_animation.html' created. Open it in your browser.");
        } catch (IOException e) {
            System.out.println("Error writing HTML file: " + e.getMessage());
        }
    }
}

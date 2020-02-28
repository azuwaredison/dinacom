package azuwaredison89.gmail.dinacom.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import azuwaredison89.gmail.dinacom.R;

public class BantuanActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);

        webView = (WebView) findViewById(R.id.webView);
        String htmlText =  "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String html =  "<p>Lorem ipsum dolor sit amet, est oratio detraxit id, quaeque perpetua abhorreant cu his, qui choro tacimates ex. Et harum sanctus maluisset vix. Eum malis ullum te. Et deleniti periculis mei, <strong>no eam erant persecuti philosophia</strong>. Nec vivendo officiis in.</p>\n" +
                "\n" +
                "<ul>\n" +
                "\t<li>Nulla facilisi.</li>\n" +
                "\t<li>Pellentesque habitant morbi</li>\n" +
                "\t<li>Quisque vel justo.</li>\n" +
                "\t<li>Nullam posuere purus sed arcu.</li>\n" +
                "</ul>\n";

        webView.getSettings().getJavaScriptEnabled();
        webView.loadData(String.format(htmlText, html), "text/html", "utf-8");
    }
}

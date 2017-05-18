package layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ascpm.example03.R;

public class FragmentWeb extends Fragment {

    private View view;

    public FragmentWeb() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.fragment_web, container, false);
        init();
        return this.view;
    }

    private void init() {
        WebView webView = WebView.class.cast(this.view.findViewById(R.id.webView));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.kakaofriends.com");
    }
}

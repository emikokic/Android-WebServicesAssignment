package ar.edu.unc.famaf.redditreader.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import ar.edu.unc.famaf.redditreader.R;
import ar.edu.unc.famaf.redditreader.backend.Backend;
import ar.edu.unc.famaf.redditreader.backend.GetTopPostsTask;
import ar.edu.unc.famaf.redditreader.model.PostModel;
import ar.edu.unc.famaf.redditreader.ui.PostAdapter;


/**
 * A placeholder fragment containing a simple view.
 */
public class NewsActivityFragment extends Fragment {

    public NewsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_news, container, false);
        final ListView postsLV = (ListView) view.findViewById(R.id.postsLV);

        new GetTopPostsTask(){
            @Override
            protected void onPostExecute(List<PostModel> postModels) {
                super.onPostExecute(postModels);
                PostAdapter postAdapter = new PostAdapter(getContext(), R.layout.post_row, postModels);
                postsLV.setAdapter(postAdapter);
            }
        }.execute();





        return view;
    }
}

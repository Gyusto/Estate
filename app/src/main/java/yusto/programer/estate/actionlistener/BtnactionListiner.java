package yusto.programer.estate.actionlistener;

import android.widget.ImageView;

import yusto.programer.estate.home.Houses;
import yusto.programer.estate.home.Land;

public interface BtnactionListiner {
    void onHouseClick(Houses house, ImageView thumbNails);

    void onLandClick(Land land,ImageView thumbNails);
}

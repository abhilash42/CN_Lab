package in.juspay.widget.qrscanner.com.google.zxing.p025a.p026a;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import in.juspay.widget.qrscanner.C1211a.C1208d;
import java.io.IOException;

public final class C1218b {
    private static final String f2668a = C1218b.class.getSimpleName();
    private final Context f2669b;
    private boolean f2670c = true;
    private boolean f2671d = false;

    class C12161 implements OnCompletionListener {
        final /* synthetic */ C1218b f2666a;

        C12161(C1218b c1218b) {
            this.f2666a = c1218b;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    class C12172 implements OnErrorListener {
        final /* synthetic */ C1218b f2667a;

        C12172(C1218b c1218b) {
            this.f2667a = c1218b;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            mediaPlayer.stop();
            mediaPlayer.release();
            return true;
        }
    }

    public C1218b(Activity activity) {
        activity.setVolumeControlStream(3);
        this.f2669b = activity.getApplicationContext();
    }

    public void m4659a(boolean z) {
        this.f2670c = z;
    }

    public MediaPlayer m4658a() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(new C12161(this));
        mediaPlayer.setOnErrorListener(new C12172(this));
        AssetFileDescriptor openRawResourceFd;
        try {
            openRawResourceFd = this.f2669b.getResources().openRawResourceFd(C1208d.zxing_beep);
            mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
            openRawResourceFd.close();
            mediaPlayer.setVolume(0.1f, 0.1f);
            mediaPlayer.prepare();
            mediaPlayer.start();
            return mediaPlayer;
        } catch (IOException e) {
            mediaPlayer.release();
            return null;
        } catch (Throwable th) {
            openRawResourceFd.close();
        }
    }
}

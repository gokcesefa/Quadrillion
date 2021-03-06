package ViewModels.PieceViews;

import DataModels.PieceDataModels.ZPiece;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.util.Duration;
import sample.Glob;

public class ZPieceView extends PieceView {

    public ZPieceView(){
        // Create the piece
        p = new ZPiece();

        // Draw the shape
        this.getPoints().addAll(gl*-2, gl*-2,
                gl*0, gl*-2,
                gl*0, gl*0,
                gl*1, gl*0,
                gl*1, gl*1,
                gl*-1, gl*1,
                gl*-1, gl*-1,
                gl*-2, gl*-1);

        // Paint the piece
        this.setFill(Glob.ZPieceDisplacedColor);
        this.setStroke(Glob.ZPiecePlacedColor);
    }

    public void rotate(){
        RotateTransition rot = new RotateTransition();
        rot.setDuration(Duration.seconds(animationTime));
        rot.setByAngle(90);
        rot.setAxis(new Point3D(0, 0, 1));
        rot.setNode(this);
        p.rotate();
        rot.play();
        rotating = true;
        rot.setOnFinished(e -> {
            if (p.getRotationEnum() == 2 || p.getRotationEnum() == 0) {
                ScaleTransition sca = new ScaleTransition();
                sca.setDuration(Duration.seconds(animationTime / 2));
                sca.setToX(p.getRotationEnum() == 2 ? -1 : 1);
                sca.setNode(this);
                sca.play();
                sca.setOnFinished(e2 ->
                    rotating = false
                );
            }
            else
                rotating = false;
        });
    }

    public void rotateWOAnimating(){
        // Rotate the visual
        this.getTransforms().add(new Rotate(90));
        if (p.getRotationEnum() == 2 || p.getRotationEnum() == 0) {
            this.getTransforms().add(new Scale(p.getRotationEnum() == 2 ? -1 : 1, 0));
        }

        // Rotate the structure
        p.rotate();
    }

    public void adjustColor(){
        if (placed)
            this.setFill(Glob.ZPiecePlacedColor);
        else
            this.setFill(Glob.ZPieceDisplacedColor);
    }
}

package game;

import engine.scene;
import engine.window;
import engine.entity.entity;
import processing.core.PGraphics;

//math from https://scienceworld.wolfram.com/physics/DoublePendulum.html
public class DoublePendulum extends entity {

    int[] ancor = new int[2];
    float[] joint = new float[2];
    float[] end = new float[2];
    int length1 = 20;
    int length2 = 20;
    float angle1 = 0;
    float angle2 = 0;
    float mass1 = 2;
    float mass2 = 2;

    float gravity = 1;

    float a1 = ancor[0];
    float a2 = ancor[1];
    float a1_v = 0;
    float a2_v = 0;

    public DoublePendulum(int x, int y, int size, scene s, window w) {
        super(x, y, size, s, w);
        ancor[0] = w.width / 2;
        ancor[1] = 10;
    }

    @Override
    public void click() {
        // TODO Auto-generated method stub

    }

    @Override
    public void draw(PGraphics canvas) {
        float middle = canvas.width / 2;
        canvas.ellipse(ancor[0], ancor[1], 10, 10);
        canvas.ellipse(joint[0], joint[1], 10, 10);
        canvas.ellipse(end[0], end[1], 10, 10);
        // TODO Auto-generated method stub
    }

    @Override
    public void key() {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(window arg0) {
        joint[0] = (float) (length1 * Math.sin(angle1));
        joint[1] = (float) (length1 * Math.cos(angle1));

        end[0] = (float) (joint[0] + (length2 * Math.sin(angle2)));
        end[1] = (float) (joint[1] + (length2 * Math.cos(angle2)));

        float num1 = (float) (-gravity * (2 * mass1 + mass2) * Math.sin(a1));
        float num2 = (float) (-mass2 * gravity * Math.sin(a1 - 2 * a2));
        float num3 = (float) (-2 * Math.sin(a1 - a2) * mass2);
        float num4 = (float) (a2_v * a2_v * length2 + a1_v * a1_v * length1 * Math.cos(a1 - a2));
        float den = (float) (length1 * (2 * mass1 + mass2 - mass2 * Math.cos(2 * a1 - 2 * a2)));
        float a1_a = (num1 + num2 + num3 * num4) / den;

        num1 = (float) (2 * Math.sin(a1 - a2));
        num2 = (a1_v * a1_v * length1 * (mass1 + mass2));
        num3 = (float) (gravity * (mass1 + mass2) * Math.cos(a1));
        num4 = (float) (a2_v * a2_v * length2 * mass2 * Math.cos(a1 - a2));
        den = (float) (length2 * (2 * mass1 + mass2 - mass2 * Math.cos(2 * a1 - 2 * a2)));
        float a2_a = (num1 * (num2 + num3 + num4)) / den;

        float x1 = (float) (length1 * Math.sin(a1));
        float y1 = (float) (length1 * Math.cos(a1));
      
        float x2 = (float) (x1 + length2 * Math.sin(a2));
        float y2 = (float) (y1 + length2 * Math.cos(a2));
        
        joint = new float[]{x1,y1};
        end = new float[]{x2,y2};


        a1_v += a1_a;
        a2_v += a2_a;
        a1 += a1_v;
        a2 += a2_v;

    }

}

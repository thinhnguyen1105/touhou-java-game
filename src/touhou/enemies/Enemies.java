package touhou.enemies;

import bases.Animation;
import bases.ImageRender;
import bases.Utils;
import bases.GameObject;
import bases.physics.BoxCollider;
import bases.physics.PhysicsBody;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Enemies extends GameObject implements PhysicsBody {

    ArrayList<String> direction = new ArrayList<>(Arrays.asList("left", "right", "up","down","upleft","upright","downleft","downright"));

    final int SPEED = 2;

    PlayerDamage playerDamage;

    int coolDownTime = 0;

    int rightStep;
    int upStep;
    int leftStep;
    int downStep;

    int index;
    int countLeft = 0;
    int countRight = 0;
    int countUp = 0;
    int countDown = 0;

    int countAppear = 0;

    public BoxCollider boxCollider;

    public boolean appeared = false;
    boolean iteration = false;

    public Enemies() {

        this.renderer = new Animation(
                Utils.loadImage("assets/images/enemies/level0/blue/0.png"),
                Utils.loadImage("assets/images/enemies/level0/blue/1.png"),
                Utils.loadImage("assets/images/enemies/level0/blue/2.png"),
                Utils.loadImage("assets/images/enemies/level0/blue/3.png")
        );
        boxCollider = new BoxCollider(30,30);
        playerDamage = new PlayerDamage();
    }

    public void initVal() {
        rightStep = randomStepRight();
        leftStep = randomStepLeft();
        downStep = randomStepDown();
        upStep = randomStepUp();
        Collections.shuffle(direction);
        index = 0;
        countRight = 0;
        countLeft = 0;
        countUp = 0;
        countDown = 0;
    }

    public int movePattern() {//huong di chuyen cua boss
        if (index == 7) {
            iteration = true;
            return 0;
        }
        if (direction.get(index) == "left") {
            if (countLeft < leftStep) {
                position.x -= SPEED;
                countLeft++;
            } else if (countLeft >= leftStep)
            {
                index++;
            }
        }
        else if ( direction.get(index) == "right"){
            if (countRight < rightStep) {
                position.x += SPEED;
                countRight++;
            } else if (countRight >= rightStep){
                index++;
            }
        }
        else if ( direction.get(index) == "up"){
            if (countUp < upStep) {
                position.y -= SPEED;
                countUp++;
            } else if (countUp >= upStep){
                index++;
            }
        }
        else if(direction.get(index) == "down"){
            if (countDown < downStep) {
                position.y += SPEED;
                countDown++;
            } else if (countDown >= downStep){
                index++;
            }
        }
        else if(direction.get(index) == "upleft"){
            if (countLeft < leftStep) {
                position.x -= SPEED;
                countLeft++;
            }
            if (countUp < upStep) {
                position.y -= SPEED;
                countUp++;
            }
            if(countLeft >= leftStep || countUp >= upStep)
                index++;
        }
        else if(direction.get(index) == "upright"){
            if (countRight < rightStep) {
                position.x += SPEED;
                countRight++;
            }
            if (countUp < upStep) {
                position.y -= SPEED;
                countUp++;
            }
            if(countRight >= rightStep || countUp >= upStep)
                index++;
        }
        else if(direction.get(index) == "downright"){
            if (countRight < rightStep) {
                position.x += SPEED;
                countRight++;
            }
            if (countDown < downStep) {
                position.y += SPEED;
                countDown++;
            }
            if(countRight >= rightStep || countDown >= downStep)
                index++;
        }
        else if(direction.get(index) == "downleft"){
            if (countLeft < leftStep) {
                position.x -= SPEED;
                countLeft++;
            }
            if (countDown < downStep) {
                position.y += SPEED;
                countDown++;
            }
            if(countLeft >= leftStep || countDown >= downStep)
                index++;
        }
        return 1 ;
    }


    public void appear(){
        if(countAppear < 34){
            position.y += 5;
            countAppear++;
        }
        else {
            appeared = true;
            initVal();
        }
    }

    public void run(){



        if(this.appeared == false){
            this.appear();
        }
        else if(this.appeared == true){
            if(coolDownTime >= 30){
                shoot();
                coolDownTime = 0;
            }
            else coolDownTime++;
            if(this.iteration == false){
                this.movePattern();
            }
            else{
                initVal();
                this.iteration = false;
            }

        }
        boxCollider.position.set(this.position);
        this.playerDamage.run(this);


        //position.addup(0,2);
    }


    public void shoot(){
        EnemyBullets bullet = GameObject.recycle(EnemyBullets.class);
        bullet.position.set(this.position);
    }
    private int randomStepRight(){
        return ThreadLocalRandom.current().nextInt(1, 384 -(int) this.position.x)/SPEED;
    }
    private int randomStepLeft(){
        return ThreadLocalRandom.current().nextInt(1,(int)this.position.x )/SPEED;
    }
    private int randomStepUp(){
        return ThreadLocalRandom.current().nextInt(1,(int)this.position.y )/SPEED;
    }
    private  int randomStepDown(){
        return ThreadLocalRandom.current().nextInt(1,300 - (int)this.position.y)/SPEED;
    }

    public void getHit() {
        isActive = false;
        explode();
    }

    private void explode() {
        //1.Play explode sound

        //2.Add explosion
        EnemyExplosion explosion = GameObject.recycle(EnemyExplosion.class);
        explosion.position.set(this.position);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }

}
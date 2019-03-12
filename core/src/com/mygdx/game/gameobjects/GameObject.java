package com.mygdx.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.GameScreen;

public class GameObject {
    Texture img;
    int x,y,width,height;
    public static final int LEFT =0;
    public static final int UP =1;
    public static final int RIGHT =2;
    public static final int DOWN =3;
    
    public static boolean move[]=new boolean[4];
    public GameObject(Texture i){
        img=i;
        width=img.getWidth();
        height=img.getHeight();
    }
    public void setPos(int X, int Y){
        x=X;
        y=Y;
    }
    public void draw(SpriteBatch batch){
        int totalX=x+width, totalY=y+height;
        if(move[RIGHT]  /* &&(x<(Gdx.graphics.getWidth()-img.getWidth())) */ ){
            /*if(GameScreen.movable[x+1][y]){
                x++;
            }else if(GameScreen.movable[x+1][y+2] && !GameScreen.movable[x+1][y-2]){
                x++;
                y+=2;
            }else if(!GameScreen.movable[x+1][y+2] && GameScreen.movable[x+1][y-2]){
                x++;
                y-=2;
            }*/
            if(GameScreen.movable[totalX+1][y]){
                x++;
            }else if(GameScreen.movable[totalX+1][y+2] && !GameScreen.movable[totalX+1][y-2]){
                x++;
                y+=2;
            }else if(!GameScreen.movable[totalX+1][y+2] && GameScreen.movable[totalX+1][y-2]){
                x++;
                y-=2;
            }
        }
        
        if(move[LEFT] && (x>0)){
            if(GameScreen.movable[x-1][y]){
                x--;
            }else if(GameScreen.movable[x-1][y+2] && !GameScreen.movable[x-1][y-2]){
                x--;
                y+=2;
            }else if(!GameScreen.movable[x-1][y+2] && GameScreen.movable[x-1][y-2]){
                x--;
                y-=2;
            }
        }
        if(move[UP]  /* && y<Gdx.graphics.getHeight()-img.getHeight() &&*/ ){
            boolean canMoveUp=true;
            for(int i=x;canMoveUp && i<totalX+1;x++){
                canMoveUp=GameScreen.movable[i][y+1];
            }
            if(canMoveUp){
                y++;
            }else if(GameScreen.movable[x+2][y+1] && !GameScreen.movable[x-2][y+1]){
                x+=2;
                y++;
            }else if(!GameScreen.movable[x+2][y+1] && GameScreen.movable[x-2][y+1]){
                x-=2;
                y++;
            }
        }
        if(move[DOWN] && y>0 ){
            boolean canMoveDown=true;
            for(int i=x;canMoveDown && i<totalX+1;x++){
                canMoveDown=GameScreen.movable[i][y-1];
            }
            if(canMoveDown){
                y--;
            }else if(GameScreen.movable[x+2][y-1] && !GameScreen.movable[x-2][y-1]){
                x+=2;
                y--;
            }else if(!GameScreen.movable[x+2][y-1] && GameScreen.movable[x-2][y-1]){
                x-=2;
                y--;
            }
        }
        batch.draw(img, x, y);
    }
    public void dispose(){
    }
}

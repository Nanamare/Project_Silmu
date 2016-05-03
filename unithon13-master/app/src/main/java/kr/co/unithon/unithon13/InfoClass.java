package kr.co.unithon.unithon13;

/**
 * Created by daehyun on 16. 2. 14..
 */
public class InfoClass {
    public int image;
    public String str;
    public String lineNum;

    public String getLineNum() {
        return lineNum;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    public InfoClass(int image, String str,String lineNum ) {
        this.lineNum = lineNum;
        this.image = image;
        this.str = str;
    }

    public InfoClass() { }

    public InfoClass( int image, String str){
        this.image = image;
        this.str = str;
    }

    public int getImage() {
        return image;
    }
}

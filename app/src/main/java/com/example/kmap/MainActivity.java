package com.example.kmap;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.*;
import android.text.method.ScrollingMovementMethod;
public class MainActivity extends AppCompatActivity {
    private Button bt[];
    private Button clr,sta,var,all;
    private TextView tex,c1,c2,c3,c4,r1,r2,r3,r4;
    int g[][]={{0,1,3,2},{4,5,7,6},{12,13,15,14},{8,9,11,10}},sz=4,pn=0,pni=1,ms=0;String gro="",pls="",ki="",pi="",qi="",oi="",ti="";
    int as[][]=new int[4][4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIviews();
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {try{
                if(ms==0)
                {
                    if (pls.length() == 0)
                        every(pi, qi, oi, ti, as, (sta.getText().toString().equals("SOP") ? 1 : 2), ki,0,0);
                    all.setText(pni + "/" + pn);
                    output(pni);
                    pni = (pni + 1) % (pn + 1);
                    if (pni == 0)
                        pni++;

                }
                else
                {
                    all.setText("1/1");
                    pni = 1;
                    pn = 1;
                }
                }catch (Exception e){tex.setText(e.toString());}
                tex.scrollTo(0,0);

            }

        });
        bt[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[0]);calc();}

        });
        bt[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[1]);calc();}

        });
        bt[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[2]);calc();}

        });
        bt[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[3]);calc();}

        });
        bt[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[4]);calc();}

        });
        bt[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[5]);calc();}

        });
        bt[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[6]);calc();}

        });
        bt[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[7]);calc();}

        });
        bt[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[8]);calc();}

        });
        bt[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[9]);calc();}

        });
        bt[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[10]);calc();}

        });
        bt[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[11]);calc();}

        });
        bt[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[12]);calc();}

        });
        bt[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[13]);calc();}

        });
        bt[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[14]);calc();}

        });
        bt[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change(bt[15]);calc();}

        });
        var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update((var.getText().toString()).charAt(0),0);
                mar();
                calc();
            }

        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update('c',sz);
                calc();
            }

        });
        sta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sta.setText((sta.getText().toString().equals("POS"))?"SOP":"POS");
                mar();
                calc();
            }

        });
    }
    void output(int x)
    {
        String t=pls.substring(pls.indexOf("<"+(pni-1)+">")+3+(pni-1!=0?(int)Math.log10(pni-1):-2),pls.indexOf("<"+(pni)+">")).trim();
        tex.setText(t);
    }
    private void setupUIviews()
    {
        bt=new Button[16];
        bt[0]=(Button)findViewById(R.id.button1);
        bt[1]=(Button)findViewById(R.id.button2);
        bt[2]=(Button)findViewById(R.id.button3);
        bt[3]=(Button)findViewById(R.id.button4);
        bt[4]=(Button)findViewById(R.id.button5);
        bt[5]=(Button)findViewById(R.id.button6);
        bt[6]=(Button)findViewById(R.id.button7);
        bt[7]=(Button)findViewById(R.id.button8);
        bt[8]=(Button)findViewById(R.id.button9);
        bt[9]=(Button)findViewById(R.id.button10);
        bt[10]=(Button)findViewById(R.id.button11);
        bt[11]=(Button)findViewById(R.id.button12);
        bt[12]=(Button)findViewById(R.id.button13);
        bt[13]=(Button)findViewById(R.id.button14);
        bt[14]=(Button)findViewById(R.id.button15);
        bt[15]=(Button)findViewById(R.id.button16);
        clr=(Button)findViewById(R.id.clear);
        sta=(Button)findViewById(R.id.state);
        var=(Button)findViewById(R.id.size);
        all=(Button)findViewById(R.id.ball);
        tex=(TextView)findViewById(R.id.groups);
        c1=(TextView)findViewById(R.id.col1);
        c2=(TextView)findViewById(R.id.col2);
        c3=(TextView)findViewById(R.id.col3);
        c4=(TextView)findViewById(R.id.col4);
        r1=(TextView)findViewById(R.id.row1);
        r2=(TextView)findViewById(R.id.row2);
        r3=(TextView)findViewById(R.id.row3);
        r4=(TextView)findViewById(R.id.row4);
        tex.setMovementMethod(new ScrollingMovementMethod());
        calc();

    }
    void change(Button b)
    {
        if(b.getText().toString().equals("0"))
            b.setText("1");
        else if(b.getText().toString().equals("1"))
            b.setText("0");
    }
    void mar()
    {
        if(sta.getText().toString().equals("SOP"))
        switch(var.getText().toString().charAt(0))
        {
            case '4':c1.setText("C'D'");
                     c2.setText("C'D");
                     c3.setText("CD");
                     c4.setText("CD'");
                     r1.setText("A'B'");
                     r2.setText("A'B");
                     r3.setText("AB");
                     r4.setText("AB'");
                     break;
            case '3':c1.setText("B'C'");
                     c2.setText("B'C");
                     c3.setText("BC");
                     c4.setText("BC'");
                     r1.setText("A'");
                     r2.setText("A");
                     r3.setText("");
                     r4.setText("");
                     break;
            case '2':c1.setText("A'B'");
                     c2.setText("A'B");
                     c3.setText("AB");
                     c4.setText("AB'");
                     r1.setText("");
                     r2.setText("");
                     r3.setText("");
                     r4.setText("");
                     break;
        }
        else
            switch(var.getText().toString().charAt(0))
            {
                case '4':
                    c1.setText("C+D");
                    c2.setText("C+D'");
                    c3.setText("C'+D'");
                    c4.setText("C'+D");
                    r1.setText("A+B");
                    r2.setText("A+B'");
                    r3.setText("A'+B'");
                    r4.setText("A'+B");
                    break;
                case '3':
                    c1.setText("B+C");
                    c2.setText("B+C'");
                    c3.setText("B'+C'");
                    c4.setText("B'+C");
                    r1.setText("A");
                    r2.setText("A'");
                    r3.setText("");
                    r4.setText("");
                    break;
                case '2':
                    c1.setText("A+B");
                    c2.setText("A+B'");
                    c3.setText("A'+B'");
                    c4.setText("A'+B");
                    r1.setText("");
                    r2.setText("");
                    r3.setText("");
                    r4.setText("");
                    break;
            }

    }
    void update(char ch,int n)
    {
        if(n==0){
        if(ch=='4')
            n=3;
        else if(ch=='3')
            n=2;
        else
            n=4;
        var.setText(n+"-var");
        sz=n;
        }

        for(int i=0;i<16;i++)
        {
            if(i/4<n-1+(n/4))
                bt[i].setText((sta.getText().toString().equals("POS"))?"1":"0");
            else
                bt[i].setText("X");
        }
    }


        void put(int k[][],int l[][])
        {
            for(int i=0;i<4;i++)
            {
                for(int j=0;j<4;j++)
                    k[i][j]=l[i][j];
            }
        }
        String oct_column_row(int a[][])
        {
            String t="";
            for(int i=0;i<4;i++)
            {
                int b[][]=new int[4][4],fc=0,fr=0;
                put(b,a);
                String t1="",t2="";
                for(int j=0;j<4;j++)
                {
                    if(fc==0)
                        if(b[i][j]==0 || b[(i+1)%4][j]==0)
                        {
                            fc=1;break;
                        }
                        else
                        {
                            b[i][j]++;b[(i+1)%4][j]++;
                            t1=t1+i+j+","+((i+1)%4)+j+",";
                        }
                }
                if(fc==0)
                {
                    t=t1+" "+t;
                    put(a,b);
                }
                put(b,a);
                for(int j=0;j<4;j++)
                {
                    if(fr==0)
                        if(b[j][i]==0 || b[j][(i+1)%4]==0 )
                        {
                            fr=1;break;
                        }
                        else
                        {
                            b[j][i]++; b[j][(i+1)%4]++;
                            t2=t2+j+i+","+j+((i+1)%4)+",";
                        }
                }
                if(fr==0)
                {
                    t=t2+" "+t;
                    put(a,b);
                }
            }
            return t;
        }
        String quad_column_row(int a[][])
        {
            String t="";
            for(int i=0;i<4;i++)
            {

                int b[][]=new int[4][4],fc=0,fr=0;
                put(b,a);
                String t1="",t2="";
                for(int j=0;j<4;j++)
                {
                    if(fc==0)
                        if(b[i][j]==0)
                        {
                            fc=1;break;
                        }
                        else
                        {
                            b[i][j]++;
                            t1=t1+i+j+",";
                        }
                }
                if(fc==0)
                {
                    t=t1+" "+t;
                    put(a,b);
                }
                put(b,a);
                for(int j=0;j<4;j++)
                {
                    if(fr==0)
                        if(b[j][i]==0)
                        {
                            fr=1;break;
                        }
                        else
                        {
                            b[j][i]++;
                            t2=t2+j+i+",";
                        }
                }
                if(fr==0)
                {
                    t=t2+" "+t;
                    put(a,b);
                }
            }

            return t;
        }
        String midQuad(int a[][])
        {
            String t="";
            for(int i=0;i<4;i++)
            {
                for(int j=0;j<4;j++)
                {
                    int b[][]=new int[4][4];
                    put(b,a);
                    int x=i,y=j,fc=0;
                    String t1="";
                    for(int k=1;k<=4;k++)
                    {
                        if(fc==0)
                            if(b[x][y]==0)
                            {
                                fc=1;break;
                            }
                            else
                            {
                                b[x][y]++;
                                t1=t1+x+y+",";
                            }
                        switch(k)
                        {
                            case 1:x=(4+x-1)%4;break;
                            case 2:y=(4+y-1)%4;break;
                            case 3:x=(x+1)%4;break;
                            case 4:y=(y+1)%4;break;
                        }
                    }
                    if(fc==0)
                    {
                        t=t+t1+" ";
                        put(a,b);
                    }
                }
            }
            return t;
        }
        String pair_single(int a[][])
        {
            String t="";
            for(int i=0;i<4;i++)
            {
                for(int j=0;j<4;j++)
                {
                    if(a[i][j]==1)
                    {
                        int m=99;
                        for(int k=1;k<=4;k++)
                        {
                            int xx=i,yy=j;
                            switch(k)
                            {
                                case 1:xx=(4+xx-1)%4;break;
                                case 2:yy=(4+yy-1)%4;break;
                                case 3:xx=(xx+1)%4;break;
                                case 4:yy=(yy+1)%4;break;
                            }
                            if(a[xx][yy]!=0 )
                            {
                                m=90;
                                t=t+i+j+","+xx+yy+", ";
                                a[xx][yy]++;
                                a[i][j]++;

                            }
                        }
                        if(m==99)
                        {
                            t=t+i+j+", ";
                            a[i][j]++;
                        }

                    }
                }
            }
            return t;
        }
        String removeredundant(int a[][],String s)
        {
            StringTokenizer st1=new StringTokenizer(s);
            String t="";
            while(st1.hasMoreTokens())
            {
                int b[][]=new int[4][4],f=0;
                put(b,a);
                String ss=st1.nextToken();
                StringTokenizer st2=new StringTokenizer(ss,",");
                while(st2.hasMoreTokens())
                {
                    String sss=st2.nextToken();
                    int x=sss.charAt(0)-48,y=sss.charAt(1)-48;
                    if(b[x][y]>2)
                        b[x][y]--;
                    else
                    {f=1;break;}
                }
                if(f==0)
                    put(a,b);
                else
                    t=t+ss+" ";
            }
            return t;
        }
        String Expression(String s,int ch)
        {
            String z1[][]={{"abcd","abcD","abCD","abCd"},{"aBcd","aBcD","aBCD","aBCd"},{"ABcd","ABcD","ABCD","ABCd"},{"Abcd","AbcD","AbCD","AbCd"}};
            String z2[][]={{"ABCD","ABCd","ABcd","ABcD"},{"AbCD","AbCd","Abcd","AbcD"},{"abCD","abCd","abcd","abcD"},{"aBCD","aBCd","aBcd","aBcD"}};
            StringTokenizer st1=new StringTokenizer(s);
            String t="";
            while(st1.hasMoreTokens())
            {
                t=t+((ch==2)?"(":"");
                String ss=st1.nextToken(),k="",m="";;
                StringTokenizer st2=new StringTokenizer(ss,",");
                int c=st2.countTokens();
                switch(c)
                {
                    case 1:m="Single(";break;
                    case 2:m="Pair(";break;
                    case 4:m="Quad(";break;
                    case 8:m="Octa(";break;
                }
                while(st2.hasMoreTokens())
                {
                    String sss=st2.nextToken();
                    int x=sss.charAt(0)-48,y=sss.charAt(1)-48;
                    m=m+g[x][y]+",";
                    k=k+((ch==1)?z1[x][y]:z2[x][y]);
                }
                for(int i=0;i<4;i++)
                {
                    if(c==count(k,(char)(97+i)))
                        t=t+(char)(97+i)+((ch==2)?"+":"");
                    if(c==count(k,(char)(65+i)))
                        t=t+(char)(65+i)+((ch==2)?"+":"");
                }
                t=((ch==1)?t+"+":t.substring(0,t.length()-1)+")");
                gro=gro+(m.substring(0,m.length()-1)+")")+"\n";
            }
            return ((ch==1)?t.substring(0,t.length()-1):t);
        }
        int count(String s,char c)
        {
            int k=0;
            for(int i=0;i<s.length();i++)
                if(c==s.charAt(i))
                    k++;
            return k;
        }
        String replace(String s)
        {
            String t="";
            for(int i=0;i<s.length();i++)
            {
                char ch=s.charAt(i);
                if(ch>=97 && ch<=122)
                    t=t+(char)(ch-32)+"'";
                else
                    t=t+ch;
            }
            return t;
        }
        String reduce(String s)
        {
            String t="";
            if(sz==4)
                t=s;
            else if(sz==3)
            {
                for(int i=0;i<s.length();i++)
                {
                    char ch=s.charAt(i);
                    if(Character.isAlphabetic(ch) && ch!='A' && ch!='a')
                        t=t+(char)(ch-1);
                    else if(ch!='A' && ch!='a')
                        t=t+ch;
                }
            }
            else if(sz==2)
            {
                for(int i=0;i<s.length();i++)
                {
                    char ch=s.charAt(i);
                    if(ch=='C' || ch=='c' || ch=='D' || ch=='d')
                        t=t+(char)(ch-2);
                    else if(ch!='A' && ch!='a' && ch!='B' && ch!='b')
                        t=t+ch;
                }
            }
            System.out.println(t);
            s="";
            for(int i=0;i<t.length();i++)
            {
                char ch=t.charAt(i);
                if(ch=='+')
                {
                    if(Character.isAlphabetic(t.charAt(i-1)) && Character.isAlphabetic(t.charAt(i+1)))
                        s=s+ch;
                    else if(t.charAt(i-1)==')' && t.charAt(i+1)=='(')
                        s=s+ch;
                }
                else
                    s=s+ch;
            }
            return s;
        }
        void calc()
        {
            tex.scrollTo(0,0);
            ms=0;
            pni=1;
            pls="";
            pn=0;
            all.setText("ALL");
            gro="";String pos="";
            int a[][]=new int[4][4],b[][]=new int[4][4];
            for(int i=0;i<4;i++)
            {
                for(int j=0;j<4;j++)
                {
                    int nim=bt[4*i+j].getText().toString().charAt(0)-48;
                    if(nim>1)
                        a[i][j]=0;
                    else
                        a[i][j]=((sta.getText().toString().equals("SOP"))?nim:(nim+1)%2);
                    if(a[i][j]==1)
                        pos=pos+g[i][j]+",";
                }
                put(as,a);
            }
            String t="";
            try {
                put(b,a);
                String p=pair_single(a);
                String q1=quad_column_row(a);
                String q2=midQuad(a);

                String o=oct_column_row(a);
                pi=p;qi=q1+q2;oi=o;
                t =pairemoveredundant(a,p)+quadremoveredundant(a,q1,q2,o);
                String nt=alternate(b);
                if(count(t,' ')>count(nt,' '))
                    t=nt;
                ti=t;
                t = Expression(t, (sta.getText().toString().equals("SOP")) ? 1 : 2);
                t = reduce(t);
                t = replace(t);
                if (t.equals("()") || t.equals("(A')(A)"))
                {t = "0";gro="";ms=1;}
                else if(t.length()==0 || t.equals("A+A'"))
                {t="1";gro="";ms=1;}

            }
            catch(Exception e){t="0";gro="";ms=1;}
            ki=pos;
            int pc=count(gro,"Pair"),qc=count(gro,"Quad");
            if((pc==4 && qc==2)||qc==5)
            {
                every(pi, qi, oi, ti, as, (sta.getText().toString().equals("SOP") ? 1 : 2), ki,0,-1);
                if(pn>0)
                    output(pni);
            }
            else if(pc==5)
            {
                every(pi, qi, oi, ti, as, (sta.getText().toString().equals("SOP") ? 1 : 2), ki,-1,0);
                if(pn>0)
                    output(pni);
            }
            if(pn==0){
                pni=1;
                pls="";
                pn=0;
                if (pos.length() > 0)
                    pos = ((sta.getText().toString().equals("SOP")) ? "Σ" : "π") + "(" + pos.substring(0, pos.length() - 1) + ")=";
                tex.setText(((gro.length() > 0) ? "Groups\n" : "") + gro + "\nF(A,B" + ((sz > 2) ? ",C" : "") + ((sz > 3) ? ",D" : "") + ")=" + pos + "\n" + t);
            }
        }
        String alternate(int a[][])
        {
            int b[][]=new int[4][4];
            String t=midQuad(a)+quad_column_row(a)+oct_column_row(a);
            t=removeredundant(a,t);
            t=reduced_pair_single(a)+t;
            return t;
        }
        int count(String t,String s)
        {
            int p=t.indexOf(s);
            if(p==-1)
                return 0;
            else
                t=t.substring(0,p)+t.substring(p+1);
            return 1+count(t,s);
        }
    String pairemoveredundant(int a[][],String p)
    {
        String t="",w="";
        for(int i=0;i<p.length();i++)
        {
            char ch=p.charAt(i);
            if(ch==' ')
            {
                t=w+ch+t;
                w="";
            }
            else
                w=w+ch;
        }
        int b[][]=new int [4][4];
        put(b,a);
        String q=removeredundant(a,p);
        String r=removeredundant(b,t);
        if(r.length()<q.length())
        {
            put(a,b);
            return r;
        }
        else
            return q;
    }
    String quadremoveredundant(int a[][],String q1,String q2,String o)
    {
        int b[][]=new int[4][4];

        put(b,a);
        String t1=removeredundant(b,q1+q2+o);
        String t2=removeredundant(a,mix(q1,q2)+o);
        if(t1.length()<t2.length())
        {
            put(a,b);
            return t1;
        }
        else
            return t2;

    }
    String mix(String v1,String v2)
    {
        StringTokenizer st1=new StringTokenizer(v2," ");
        StringTokenizer st2=new StringTokenizer(v1," ");
        String t="";
        while(st1.hasMoreTokens() || st2.hasMoreTokens())
        {
            if(st1.hasMoreTokens())
                t=t+st1.nextToken()+" ";
            if(st2.hasMoreTokens())
                t=t+st2.nextToken()+" ";
        }
        return t;

    }
    String reduced_pair_single(int a[][])
    {
        String t="";
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(a[i][j]==1)
                {
                    int x=0,y=0,m=99;
                    for(int k=1;k<=4;k++)
                    {
                        int xx=i,yy=j;
                        switch(k)
                        {
                            case 1:xx=(4+xx-1)%4;break;
                            case 2:yy=(4+yy-1)%4;break;
                            case 3:xx=(xx+1)%4;break;
                            case 4:yy=(yy+1)%4;break;
                        }
                        if(a[xx][yy]!=0 && a[xx][yy]<=m)
                        {
                            m=a[xx][yy];
                            x=xx;y=yy;
                        }
                    }
                    if(m==99)
                    {
                        t=t+i+j+", ";
                        a[i][j]++;
                    }
                    else
                    {
                        t=t+i+j+","+x+y+", ";
                        a[x][y]++;
                        a[i][j]++;
                    }
                }
            }
        }
        return t;
    }
    void display(String t,int ch,String k)
    {
        String pl="";
        gro="";
        t=Expression(t,ch);
        t=reduce(t);
        pl=pl+"\nGroups\n"+gro+"\nF(A,B"+((sz>2)?",C":"")+((sz>3)?",D":"")+")="+((ch==1)?"Σ":"π")+"("+k.substring(0,k.length()-1)+")=\n"+replace(t);
        if(pls.indexOf(pl)==-1)
        {
            pn++;
            pls=pls+pl+"<"+pn+">";
        }
    }


    boolean valid(String s,int a[][])
    {
        if(s.length()==0)
            return false;
        int b[][]=new int[4][4];
        StringTokenizer st1=new StringTokenizer(s);
        while(st1.hasMoreTokens())
        {
            String ss=st1.nextToken();
            StringTokenizer st2=new StringTokenizer(ss,",");
            while(st2.hasMoreTokens())
            {
                String sss=st2.nextToken();
                try{
                    b[sss.charAt(0)-48][sss.charAt(1)-48]=1;
                }
                catch(Exception e){}
            }
        }
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
                if(a[i][j]!=b[i][j])
                    return false;
        }
        return true;
    }

   void every(String pp,String q,String o,String t,int a[][],int ch,String k,int pr,int qr)
    {
        int n[]=new int[4],c=0;
        for(int i=0;i<t.length();i++)
        {
            char crt=t.charAt(i);
            if(crt==' ')
            {
                n[(int)(Math.log10(c)/Math.log10(2))]++;
                c=0;
            }
            else if(crt==',')
                c++;
        }
        n[1]=n[1]+pr;
        n[2]=n[2]+qr;
        int hn[]=new int[4];String w="",p="",s="";
        for(int i=0;i<pp.length();i++)
        {
            char crt=pp.charAt(i);
            if(crt==' ')
            {
                hn[c-1]++;
                if(c==1)
                    s=s+w+' ';
                else
                    p=p+w+' ';
                c=0;w="";
            }
            else
                w=w+crt;
            if(crt==',')
                c++;
        }
        p=repair(a);
        hn[1]=count(p,' ');
        hn[2]=count(q,' ');
        hn[3]=count(o,' ');
        String ap[]=combinations(n[1],hn[1],p);

        String aq[]=combinations(n[2],hn[2],q);


        for(int i=0;i<ap.length;i++)
        {
            for(int j=0;j<aq.length;j++)
            {

                String nwe="";


                if(s!=null)
                    nwe=nwe+s.trim()+" ";
                if(ap[i]!=null)
                    nwe=nwe+ap[i].trim()+" ";
                if(aq[j]!=null)
                    nwe=nwe+aq[j].trim()+" ";
                if(o!=null)
                    nwe=nwe+o.trim()+" ";

                if(valid(nwe,a))
                {
                    display(nwe,ch,k);
                }

            }
        }
    }

    double nCr(int n,int r,int i)
    {
        if(i==0)
            return 1;
        double f=1.0;
        if(i>(n-r))
            f=f*i;
        if(i<=r)
            f=f/i;
        return f*nCr(n,r,i-1);
    }
    String strimul(String s,int n)
    {
        String t="";
        for(int i=1;i<=n;i++)
            t=t+s;
        return t;
    }
    String[] toArray(String t,char c)
    {
        StringTokenizer st1=new StringTokenizer(t,""+c);
        String a[]=new String[st1.countTokens()];
        for(int i=0;i<a.length;i++)
            a[i]=st1.nextToken()+" ";
        return a;
    }
    boolean takable(String t)
    {
        for(int i=0;i<t.length()-1;i++)
        {
            if(t.charAt(i)>=t.charAt(i+1))
                return false;
        }
        return true;
    }
    String[] combinations(int x,int y,String t)
    {
        String gv[]=toArray(t,' ');

        String v[]=new String[(int)nCr(y,x,y)+1];y++;
        long u=BaseToDeci(strimul(DecitoBase(y-1,y,""),x),y,0,0);
        long l=BaseToDeci("1"+strimul("0",x-1),y,0,0);
        int k=1;
        for(long i=l;i<=u;i++)
        {
            String d=DecitoBase(i,y,""),nt="";
            if(takable(d))
            {

                for(int j=0;j<d.length();j++)
                {
                    nt=nt+gv[(int)BaseToDeci(""+d.charAt(j),y,0,0)-1];
                }

                v[k]=nt;
                k++;
                if(k==v.length)
                    break;
            }
        }


        return v;
    }
    String DecitoBase(long n , int b,String s)
    {
        if(n==0)
            return s;
        else
        {
            long d = n%b;
            if(d>=0 && d<=9)
                return DecitoBase(n/b,b,""+d+s);
            else
                return DecitoBase(n/b,b,""+(char)(d+55)+s);
        }
    }
    long BaseToDeci(String s,int b,long n,int i)
    {
        if(s.equals(""))
            return n;
        else
        {
            if(s.charAt(s.length()-1)>64)
                n=n+(long)(Math.pow(b,i)*(int)(s.charAt(s.length()-1)-55));
            else
                n=n+(long)(Math.pow(b,i)*(int)(s.charAt(s.length()-1)-48));
            return BaseToDeci(s.substring(0,s.length()-1),b,n,++i);
        }
    }
    String repair(int a[][])
    {
        String t="";
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(a[i][j]==1)
                {

                    for(int k=1;k<=2;k++)
                    {
                        int xx=i,yy=j;
                        switch(k)
                        {
                            case 1:xx=(4+xx-1)%4;break;
                            case 2:yy=(4+yy-1)%4;break;
                            case 3:xx=(xx+1)%4;break;
                            case 4:yy=(yy+1)%4;break;
                        }
                        if(a[xx][yy]!=0 )
                        {

                            t=t+i+j+","+xx+yy+", ";

                        }
                    }


                }
            }
        }
        return t;
    }
    /*boolean check(int a[][])
    {
        int c=0,s=0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(a[i][j]==0)
                {
                    c++;
                    s=s+g[i][j];
                }
                if(c>2)
                    return false;
            }
        }
        return (c==2 && s==15);
    }*/

}
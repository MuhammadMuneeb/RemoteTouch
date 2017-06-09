package org.androidpccontroller.remotetouch;


public class Constants {
    private static String Ip;
    public static final int SERVER_PORT = 11258;
    private boolean isConnected;

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public static String getIp() {
        return Ip;
    }

    public static void setIp(String ip) {
        Ip = ip;
    }

    public static final String KEYBOARD = "keyboard";

    //For mouse
    public static final String MOUSE_RIGHT_CLICK="right_click";
    public static final String MOUSE_LEFT_CLICK="left_click";
    public static final String MOUSE_SCROLL_WHEEL="scroll";
    //For keyboard
    public static final String key_q="q";
    public static final String key_w="w";
    public static final String key_e="e";
    public static final String key_r="r";
    public static final String key_t="t";
    public static final String key_y="y";
    public static final String key_u="u";
    public static final String key_i="i";
    public static final String key_o="o";
    public static final String key_p="p";
    public static final String key_a="a";
    public static final String key_s="s";
    public static final String key_d="d";
    public static final String key_f="f";
    public static final String key_g="g";
    public static final String key_h="h";
    public static final String key_j="j";
    public static final String key_k="k";
    public static final String key_l="l";
    public static final String key_z="z";
    public static final String key_x="x";
    public static final String key_c="c";
    public static final String key_v="v";
    public static final String key_b="b";
    public static final String key_n="n";
    public static final String key_m="m";
    public static final String key_Q="Q_caps";
    public static final String key_W="W_caps";
    public static final String key_E="E_caps";
    public static final String key_R="R_caps";
    public static final String key_T="T_caps";
    public static final String key_Y="Y_caps";
    public static final String key_U="U_caps";
    public static final String key_I="I_caps";
    public static final String key_O="O_caps";
    public static final String key_P="P_caps";
    public static final String key_A="A_caps";
    public static final String key_S="S_caps";
    public static final String key_D="D_caps";
    public static final String key_F="F_caps";
    public static final String key_G="G_caps";
    public static final String key_H="H_caps";
    public static final String key_J="J_caps";
    public static final String key_K="K_caps";
    public static final String key_L="L_caps";
    public static final String key_Z="Z_caps";
    public static final String key_X="X_caps";
    public static final String key_C="C_caps";
    public static final String key_V="V_caps";
    public static final String key_B="B_caps";
    public static final String key_N="N_caps";
    public static final String key_M="M_caps";
    //For numbers
    public static final String key_0="0";
    public static final String key_1="1";
    public static final String key_2="2";
    public static final String key_3="3";
    public static final String key_4="4";
    public static final String key_5="5";
    public static final String key_6="6";
    public static final String key_7="7";
    public static final String key_8="8";
    public static final String key_9="9";
    //For symbols
    public static final String key_excl= "!";
    public static final String key_at= "@";
    public static final String key_hash= "#";
    public static final String key_dollar= "$";
    public static final String key_prcnt= "%";
    public static final String key_cap= "^";
    public static final String key_amp= "&";
    public static final String key_asterisk= "*";
    public static final String key_brackOpen= "(";
    public static final String key_brackClose= ")";
    public static final String key_minus= "-";
    public static final String key_underscore= "_";
    public static final String key_equals= "=";
    public static final String key_plus= "+";
    public static final String key_tildApostrophe= "`";
    public static final String key_tild= "~";
    public static final String key_sqBrackOP= "[";
    public static final String key_curlyBrackOp= "{";
    public static final String key_sqBrackClose= "]";
    public static final String key_curlyBrackClose= "}";
    public static final String key_backSlash= "backSlash";
    public static final String key_StickThing= "|";
    public static final String key_semicolon= ";";
    public static final String key_colon= ":";
    public static final String key_quote= "'";
    public static final String key_dblQuote= "dblQuote";
    public static final String key_comma= ",";
    public static final String key_openTag= "<";
    public static final String key_period= ".";
    public static final String key_closeTag= ">";
    public static final String key_rightSlash= "/";
    public static final String key_question= "?";
    public static final String key_enter= "enter";
    public static final String key_back= "backspace";
    public static final String space ="Space";
    public static final String copy = "copy";
    public static final String paste = "paste";
}

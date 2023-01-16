package com.hxgfk.response;

import com.hxgfk.util.Array;

public class ResponseParams {
    private interface param{
        String k();
        String v();
    }

    private param[] Params = new param[]{};

    public ResponseParams(){}

    public void add(String param, String value){
        this.Params = (ResponseParams.param[]) Array.add(new param() {
            @Override
            public String k() {
                return param;
            }

            @Override
            public String v() {
                return value;
            }
        }, this.Params);
    }

    public String build(){
        boolean f = false;
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<this.Params.length;i++){
            if (i != 0){
                param p = this.Params[i];
                sb.append("&").append(p.k()).append("=").append(p.v());
            }else {
                param p = this.Params[i];
                sb.append(p.k()).append("=").append(p.v());
            }
        }
        return sb.toString();
    }
}

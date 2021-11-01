let sk = false;

function findByPage(page,length,type,begin,end,path) {
    if (type==0){
        if (page+1==begin) {
            sk=true;
            $("#left").click();
        }else {
            window.location.href="/"+path+"?page="+page+"&length="+length
        }
    }else {
        if (page-1==end) {
            sk=true;
            $("#right").click();
        }else {
            window.location.href="/"+path+"?page="+page+"&length="+length
        }
    }
}

function right(type,a,b,page,begin,end,path) {
    if (type == 1) {
        if (a >= b) {
            return false;
        }else {
            end += 4;
            begin +=4;
        }
    } else {
        if (a <= b) {
            return false;
        } else {
            if (end - begin < 3) {
                end = begin - 1;
            } else {
                end -= 4;
            }
            begin -= 4;
        }
    }
    if (sk) {
        sk=false;
        window.location.href="/"+path+"?page="+page+"&length="+4+"&begin="+begin+"&end="+end
    }else {
        window.location.href="/"+path+"?page="+begin+"&length="+4+"&begin="+begin+"&end="+end
    }
}
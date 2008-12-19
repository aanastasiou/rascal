module Numbers-example

rule n1 number("0" <Digit+ Ds>) => number(<Ds>);


rule n2 number("0" <[0-9]+ Ds>) => number(<Ds>);


Real truncate(Real R){
    switch (R) {
       case real(<Number Num> "." <Digit+ Ds>) => real(<Num> "." "0");
    }
}
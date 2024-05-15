int a;

void hello( string s )
begin
    s = "world";
    print "Hello " + s;
end

void main()
begin
    int x;
    x = 5;
    print x;
    hello( "world");
    //x = max( 3, 4 );
    print x;
end

int max( int a, int b )
begin
    int y, z;
    real e = 5;
    y = 2;
    if a > b then
        z = 5;
    else
        z = 6;
    return z;
end
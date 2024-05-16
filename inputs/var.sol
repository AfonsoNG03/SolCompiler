int x = 10;
int y = 20;

int soma (int a, int b)
begin
    return a + b;
end

void main()
begin
    int a = x;
    int b = y;
    int c = soma(a, b);
    int d = subtracao(a, b);
    int e = max(c, d);
    print e;
end

int subtracao (int a, int b)
begin
    return a - b;
end

int max (int a, int b)
begin
    if (a > b) then begin
        return a;
    end else begin
        return b;
    end
end










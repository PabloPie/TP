module ArrayPolynomial where
type Polynomial = [Float]

x :: Polynomial
x =  [1 , 0]

coef :: Float -> Polynomial
coef c = [c]

padd :: [Polynomial] -> Polynomial
padd [] = error "Lista vacia"
padd x = foldl1 polysum x

polysum :: Polynomial -> Polynomial -> Polynomial
polysum [] [] = []
polysum x [] = x
polysum [] y = y
polysum x y = polysum (init x)  (init y)++(last x last y)

pmul :: [Polynomial] -> Polynomial
pmul [] = error "Lista vacia"
pmul x = foldl1 polymul x

polymul :: Polynomial -> Polynomial -> Polynomial
polymul _ [] = error "No posible es"
polymul [] _ = [0]
polymul x y = 

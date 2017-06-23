main = do
    x <- getLine
    let alcool = read x :: Double
    y <- getLine
    let gasolina = read y :: Double
    z <- getLine
    let qtd = read z :: Double
    print(qualOMelhor(alcool, gasolina, qtd))

qualOMelhor :: (Double, Double, Double) -> Double
qualOMelhor (alcool, gasolina, litros)
    | alcool >= 0.7 * gasolina = gasolina * litros
    | otherwise = alcool * litros

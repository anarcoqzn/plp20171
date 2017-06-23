main = do
    input <- getLine
    print(valorEstacionamento(input))

valorEstacionamento :: String -> Int
valorEstacionamento x
 | x == "moto" = 5
 | x == "carro" = 10
 | otherwise = 30

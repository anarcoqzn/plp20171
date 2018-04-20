main = do
    putStrLn "Digite um numero"
    input <- getLine
    let num = read input :: Int
    putStrLn(ehPrimo(num))


ehPrimo :: Int -> String
ehPrimo 0 = "Nao eh primo"
ehPrimo 1 = "Nao eh primo"
ehPrimo n
    | null(fatores(n)) = "Eh Primo"
    | otherwise = "Nao eh primo"

fatores :: Int -> [Int]
fatores n = [x | x <- [2..n-1], n `mod` x == 0]

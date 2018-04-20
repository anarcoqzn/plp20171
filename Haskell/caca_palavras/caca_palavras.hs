import Syste
main = do	
	putStrLn "Digite as palavras separadas por espaco (Min: 4, Max: 10)"
	input <- getLine
	let palavras = (words input)
	imprimeMatriz(caca_palavra)

caca_palavra = ["","","","","","","","","",""]

imprimeMatriz :: [String] -> IO()
imprimeMatriz [] = putStrLn""
imprimeMatriz (m:ms) = do
	putStrLn m
	imprimeMatriz(ms)


horizontal :: ([String], String) -> [String]
horizontal(caca_palavra, palavra) = do
	x <- randomSimples 10
	print x



randomSimples :: Int -> IO Int
randomSimples x = Sistem.randomRIO(1,x)

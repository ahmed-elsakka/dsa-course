def count_unique_words(text):
    words = text.split()
    unique_words = set(words)
    return len(unique_words)


text_input = ("Python is a high-level programming language. "
              "Python's simplicity and flexibility make it a popular programming language. "
              "Learning Python is essential for mastering web development, data science, and automation tasks.")

unique_words_count = count_unique_words(text_input)
print("Number of unique words: ", unique_words_count)


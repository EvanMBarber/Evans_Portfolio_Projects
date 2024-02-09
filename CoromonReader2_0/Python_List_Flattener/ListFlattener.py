
 

d = ['good morning', 'hello', 'chair', 'python', ['music', 5, 'flowers', 'facebook', 'instagram', 'snapchat', ['On my Own', 'monster',[2, {"so_long":"farewell","I wish you":"good bye"}], 'Words dont come so easily', 'lead me right']], 'Stressed Out', 'Pauver Coeur', 'Reach for Tomorrow', 'mariners song', 'Wonder sleeps here']

flattened = [] #this list is for putting non list objecys in
while len(d) != 0: #Keep running while d is not empty
 not_flattened_list = [] #creating a list to put list objects in
 for elem in d:
     # if an object is anything but a list, it gets put into flattend, else it gets put into not flattend
    if type(elem) == list:
        not_flattened_list += elem
    
    else:
        flattened.append(elem)
 #updating list so that elements removed apply
 d = not_flattened_list

print(flattened)

